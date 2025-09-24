//자료형, 목정에 따라 가장 간결하고 명확하게 구현하기 위한 다양한 반복문이 존재.


let members = [
    "최지원",
    "김지원",
    "이지원",
    "박지원",
    "정지원",
    "황지원"
]

console.log(members.push("신지원"));
console.log(members);

console.log(members.splice(1,3));
console.log(members);

console.log(members.slice(0,3));
console.log(members)

let members2 = [
    ...members,
    "신지원"
]

console.log(members2);

let choi = {
    name : "jiwon",
    age : 24,
    gender : "남"
};