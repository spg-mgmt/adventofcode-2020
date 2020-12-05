package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"
	"strconv"
	"strings"
)

func main() {
	file, err := os.Open("../data.txt")
	if err != nil {
		log.Fatal(err)
	}

	data, err := ioutil.ReadAll(file)
	if err != nil {
		log.Fatal(err)
	}

	lines := strings.Split(string(data), "\n")

	for i := 0; i < len(lines); i++ {
		lines[i] = strings.Replace(lines[i], "-", " ", -1)
		lines[i] = strings.Replace(lines[i], ":", "", -1)
	}

	var count int = 0

	for i := 0; i < len(lines); i++ {
		linespart := strings.Split(string(lines[i]), " ")
		minc, _ := strconv.Atoi(linespart[0])
		maxc, _ := strconv.Atoi(linespart[1])
		target := linespart[2]
		teststr := linespart[3]

		charcount := strings.Count(teststr, target)
		if charcount >= minc && charcount <= maxc {
			count++
		}
	}
	fmt.Println(count)
}
