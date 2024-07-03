function solution(arr) {
    // 최대 공약수를 구하는 함수
    function gcd(a, b) {
        while (b !== 0) {
            let temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소 공배수를 구하는 함수
    function lcm(a, b) {
        return (a * b) / gcd(a, b);
    }

    // 배열의 모든 요소의 최소 공배수를 구함
    return arr.reduce((acc, val) => lcm(acc, val));
}