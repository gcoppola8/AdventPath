/*
Easier in Js or Python than in Java
Open the browser to the input file: https://adventofcode.com/2015/day/8/input
Open the console and execute this

let input = document.body.innerText.trim();

let part1 = 0;
let part2 = 0;

input.split('\n').forEach(function(s) {
	part1 += s.length - eval(s).length;
	part2 += JSON.stringify(s).length - s.length;
});

console.log('Part One:', part1);
console.log('Part Two:', part2);

* */
