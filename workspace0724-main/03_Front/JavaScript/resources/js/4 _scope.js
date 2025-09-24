/**
 *  Scope
 *  스코프란, 변수와 함수가 접근할수 있는 유효범위
 *  즉, 이 변수/함수가 어디까지 보이고, 어디까지 쓸 수 있는지를 결정함
 * 
 *  전역스코프 : 코드 어디서든 접근 가능한 영역(전역에서 선언된 변수/함수)
 *  함수스코프 : 함수 내부에서만 접근가능한 영역(var 키워드로 선언한 값)
 *  블록스코프 : {}블록 내부에서만 접근이 가능한 영역(letm const키워드로 선언한 값)
 *  렉시컬스코프 : 선언한 위치를 기준으로 스코프를 결정(js는 렉시컬 스코프를 기반으로함)
 * 
 */

var num1 =20;

function test1(){
    console.log(num1);
}
function test2(){
    var num1 = 40;
    console.log(num1);
}
//test1(); //20(전역변수 참조);
//test2(); //40(함수 내부 변수 참조);

var num1 = 20;
var num2 = 20;
function test3(){
    var num1 = 40;
     let num2 = 20;
     test4();
     console.log(num1);
}
function test4(){
    var num2 =11;
    console.log("num1 in test4" + num1);
    console.log("num2 in test4" + num2);
}
test3();
console.log("전역 num1 : "+num1)

//함수 내부에 값이 있으면, 그 값을 사용 ,없으면 전역에서 걑을 찾아냄

//var는 함수 스코프이기 때문에 for문에 새로운 i가 생기지 않고 전역