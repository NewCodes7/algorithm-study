function solution(s) {
    var answer = '';
    s = s.split(' ').map(c => c.split(''));
    s = s.map(c1 => c1.map((c2,i) => i%2 === 0 ? c2.toUpperCase() : c2.toLowerCase()));
    return  s.map(c => c.join('')).join(' ');
}