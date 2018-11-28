/**
 *  ArraysAndPointers.c
 *
 *  
 *  Tyler Oalman
 *  version 2.0 2018-09-13
 */

#include <stdio.h>

int main()
{
	int row, col;
	int ident[5][5];
	int *iptr, *tempRow;
	int *rowPtr[5];

	/* Create identity matrix */
	for (row = 0; row < 5; row++)
	{
		for (col = 0; col < 5; col++)
		{
			if (row == col)
			{
				ident[row][col] = 1;
			}

			else
			{
				ident[row][col] = 0;
			}
		}
	}
	/* Set pointer to front of array */
	iptr = &(ident[0][0]);

	printf("*iptr: %d", *iptr);
	printf("\niptr: %d", iptr);
	printf("\n&ident[0][0]: %d", &(ident[0][0]));
	printf("\n&iptr: %d", &iptr);
	printf("\n\nPrint matrix row by row.\n");

	/* Print matrix row by row using pointers */
	for (row = 0; row < 5; row++)
	{
		for (col = 0; col < 5; col++)
		{
			printf("%d ", *(iptr + (row * 5) + col));
		}
		printf("\n");
	}

	/* Print matrix column by comumn using pointers */
	printf("\nPrint matrix column by column.\n");
	for (row = 0; row < 5; row++)
	{
		iptr = &(ident[0][row]);
		for (col = 0; col < 5; col++)
		{
			printf("%d ", *iptr);
			iptr = iptr + 5;
		}
		printf("\n");
	}

	/* Put rows in ident in rowPtr array */
	for (int i = 0; i < 5; i++)
	{
		rowPtr[i] = &(ident[i][0]);
	}

	/* Exchange first and last row */
	tempRow = rowPtr[0];
	rowPtr[0] = rowPtr[4];
	rowPtr[4] = tempRow;
	/* Print swapped matrix */
	printf("\nPrint new matrix with swapped first and last rows.\n");
	for (row = 0; row < 5; row++)
	{
		for (col = 0; col < 5; col++)
		{
			printf("%d ", *(rowPtr[row] + col));
		}
		printf("\n");
	}
}
