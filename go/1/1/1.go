package main

import (
	"fmt"
	"io/ioutil"
	"log"
	"os"
	"sort"
	"strconv"
	"strings"
)

func sliceAtoi(sa []string) ([]int, error) {
	si := make([]int, 0, len(sa))
	for _, a := range sa {
		i, err := strconv.Atoi(a)
		if err != nil {
			return si, err
		}
		si = append(si, i)
	}
	return si, nil
}

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

	intlines, err := sliceAtoi(lines)
	if err != nil {
		log.Fatal(err)
	}

	sort.Ints(intlines[:])

	var maxi int = len(intlines)

	var j int = maxi - 1
	for i := 0; i < maxi; {
		sumf := intlines[j] + intlines[i]
		if sumf > 2020 {
			j--
		}
		if sumf < 2020 {
			i++
		}
		if sumf == 2020 {
			fmt.Println(intlines[i] * intlines[j])
			break
		}
	}
}
