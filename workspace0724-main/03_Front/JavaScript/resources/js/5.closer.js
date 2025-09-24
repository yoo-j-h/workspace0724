/**
 * 클로저란?
 * 클로저는 함수와, 그 함수가 선언된 시점의 렉시컬 환경의 조합.
 * 즉, 내부함수의 선언시점에 외부함수의 변수를 함계 저장해서 사용하는것을 클로저라고함
 * 콜백/이벤트 헨들러/모듀패턴에서 핵심적인 역할을 함.
 */

function getCounter(){

    let count = 0;
    function increase(){
        count++;
        return count;
    }
    return increase; //내부함수를 반환 -> 외부에서도 count접근 가능
}
const run = getCounter();
console.log(run());
console.log(run());
//count는 외부에서 직접 보이지 않지만, increase()를 통해서 변경
//run이 살아있는 한 count가 메모리에 유지됨 - > 상태유지

function out(outValue){
    function inner(innerValue){
        console.log("out : "+ outValue);
        console.log("in : "+ innerValue);
    }
    return inner;
}

const printer = out("외부함수");
printer("내부함수")

function attachOnce(el, msg){
    let clicked = false;

    el.addEventListner("click", function(){
        if(clicked) return;
        clicked = true;
        console.assert.log(msg);
    })
}