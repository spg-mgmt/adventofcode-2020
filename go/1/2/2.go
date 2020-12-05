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
	var k int = 1
	for i := 0; i < maxi; {
		diff := 2020 - intlines[i]
		sumf := intlines[j] + intlines[k] 
		if sumf > diff {
			j--
		}
		if sumf < diff {
			k++
		}
		if sumf == diff {
			fmt.Println(intlines[i] * intlines[j] * intlines[k])
			break
		}
		if k > j {
			i++
			k = i + 1
			j = maxi - 1
		}
	}
}
