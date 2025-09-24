//====== 전역 변수 ========
let ledger = JSON.parse(localStorage.getItem('ledger_items')) || [];
let filterState = 'all';              
let currentType = 'income';           

// ====== DOM 요소 ========
const listEl = document.getElementById('balance-list');
const memoInput = document.getElementById('memo-input');
const amountInput = document.getElementById('amount-input');
const addBtn = document.getElementById('balance-add-btn');
const filterBtns = document.querySelectorAll('.filter-buttons button');

const inputIncomeBtn  = document.getElementById('inputIncome');
const inputExpensesBtn= document.getElementById('inputExpenses');

// 합계 표시 요소
const balanceHeaderEl = document.getElementById('balance');
const totalIncomeEl   = document.getElementById('balance-plus');
const totalExpenseEl  = document.getElementById('balance-minus');
const totalBalanceEl  = document.getElementById('balance-total');

// ===== 초기화 =====
function init(){
    bindEvents();
    render();
}

function bindEvents(){
    addBtn.addEventListener('click', addItem);

    memoInput.addEventListener('keydown', function(e){
        if(e.key === 'Enter') addItem();
    });
    amountInput.addEventListener('keydown', function(e){
        if(e.key === 'Enter') addItem();
    });

    inputIncomeBtn.addEventListener('click', function(){
        currentType = 'income';
        inputIncomeBtn.classList.add('active');
        inputExpensesBtn.classList.remove('active');
    });
    inputExpensesBtn.addEventListener('click', function(){
        currentType = 'expenses';
        inputExpensesBtn.classList.add('active');
        inputIncomeBtn.classList.remove('active');
    });

    filterBtns.forEach(function(btn){
        btn.addEventListener('click', function(ev){
            setFilter(ev.target.dataset.filter);
        });
    });

    listEl.addEventListener('click', function(e){
        const li = e.target.closest('li');
        if(!li) return;
        const id = Number(li.dataset.id);

        if(e.target.matches('.delete-btn')){
            deleteItem(id);
            return;
        }
        if(e.target.matches('.toggle-type')){
            toggleType(id);
            return;
        }
    });
}


//=========== 데이터 조작 =======================
function addItem(){
    const memo = (memoInput.value || '').trim();
    const amount = Number((amountInput.value || '').trim());
    

    if(!memo) { memoInput.focus(); return; }
    if(isNaN(amount) || amount <= 0){ amountInput.focus(); return; }

    const item = {
        id: Date.now(),
        memo: memo,
        amount: amount,
        type: currentType,  
        createdAt: new Date().toLocaleString().slice(2,10)
    };

    ledger.push(item);
    memoInput.value = '';
    amountInput.value = '';

    saveLedger();
    render();
}

function deleteItem(id){
    let next = [];
    for(let it of ledger){
        if(it.id === id) continue;
        next.push(it);
    }
    ledger = next;
    saveLedger();
    render();
}

function toggleType(id){
    for(let it of ledger){
        if(it.id === id){
            it.type = (it.type === 'income' ? 'expenses' : 'income');
            break;
        }
    }
    saveLedger();
    render();
}

function getFiltered(){
    if(filterState === 'income'){
        const arr = [];
        for(let it of ledger){ if(it.type === 'income') arr.push(it); }
        return arr;
    }else if(filterState === 'expenses'){
        const arr = [];
        for(let it of ledger){ if(it.type === 'expenses') arr.push(it); }
        return arr;
    }
    return ledger;
}

function saveLedger(){
    localStorage.setItem('ledger_items', JSON.stringify(ledger));
}

//=========== 렌더링 ====================
function render(){
    listEl.innerHTML = '';

    const items = getFiltered();

    if(items.length === 0){
        emptyStateRender();
    }else{
        for(let it of items){
            itemRender(it);
        }
    }

    updateSummary();
}

function emptyStateRender(){
    const div = document.createElement('div');
    div.className = 'empty-state';
    div.textContent = '기록이 없습니다.';
    listEl.appendChild(div);
}

function itemRender(it){
    const isExpense = it.type === 'expenses';
    const sign = isExpense ? '-' : '+';
    const li = document.createElement('li');
    li.dataset.id = String(it.id);

    li.innerHTML = `
        <span style="margin-left:8px; ${isExpense ? 'color:rgb(228, 81, 81);' : 'color:rgb(81, 228, 81);'}">
            ${isExpense ? '지출' : '수입'}
        </span>
        <span>${it.memo}</span>
        <span style="margin-left:8px; ${isExpense ? 'color:rgb(228, 81, 81);' : 'color:rgb(81, 228, 81);'}">
            ${sign}${(it.amount || 0).toLocaleString()}원
        </span>
        <span style="margin-left:8px;color:#888;">${it.createdAt || ''}</span>
        <button class="delete-btn">삭제</button>
    `;

    listEl.appendChild(li);
}

// 합계/잔액 갱신
function updateSummary(){
    let income = 0;
    let expense = 0;
    for(let it of ledger){
        if(it.type === 'income') income += it.amount;
        else expense += it.amount;
    }
    const balance = income - expense;

    if(balanceHeaderEl) balanceHeaderEl.innerHTML = `${balance.toLocaleString()}원`;
    if(totalIncomeEl)   totalIncomeEl.textContent = `${income.toLocaleString()}원`;
    if(totalExpenseEl)  totalExpenseEl.textContent = `${expense.toLocaleString()}원`;
    if(totalBalanceEl)  totalBalanceEl.textContent = `${balance.toLocaleString()}원`;
}

//======== 필터 ==============
function setFilter(filter){
    filterState = filter;

    filterBtns.forEach(function(btn){
        btn.className = (btn.dataset.filter === filter ? 'active' : '');
    });

    render();
}



//========= DOMContentLoaded =============
document.addEventListener('DOMContentLoaded', init);
