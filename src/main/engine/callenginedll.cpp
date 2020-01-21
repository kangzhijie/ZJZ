
#include <stdio.h>
#include "enginedll.h"


// example using CollectMoves:
int testCollectMoves()
{
	egMoves input;
	egExtMoves output;

	input.num = 10;
	input.arr[0] = 136;
	input.arr[1] = 120;
	input.arr[2] = 168;
	input.arr[3] = 105;
	input.arr[4] = 169;
	input.arr[5] = 121;
	input.arr[6] = 119;
	input.arr[7] = 135;
	input.arr[8] = 90;
	input.arr[9] = 153;

	CollectMoves(input, output);
	
	
	for (int i = 0; i < output.num; i++)
	{
		printf("\n move %d, pos %d, value %f", i + 1, output.arr[i].move, output.arr[i].score);
	}

	printf("\n");

	return 0;
}


// example using Scan:
int testScan1()
{
	egMoves input;

	input.num = 10;
	input.arr[0] = 136;
	input.arr[1] = 120;
	input.arr[2] = 168;
	input.arr[3] = 105;
	input.arr[4] = 169;
	input.arr[5] = 121;
	input.arr[6] = 119;
	input.arr[7] = 135;
	input.arr[8] = 90;
	input.arr[9] = 153;

	Scan(input, "input.lib", "output.lib");

	return 0;
}


int main()
{
	Init();

	testCollectMoves();
	testScan1();
}

