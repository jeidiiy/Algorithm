/**
 * Copyright (c) 2021, Ji-Yong, Jeong
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <ctype.h>

#define ALPHA_NUM 26

struct Position {
	int x;
	int y;
};

void PlayfairEncrypt();
void PlayfairDecrypt();
void strupr(char str[]);
char* eliminateDuplicatedAlpha(char str[], int size);
void makeTable(char* key);
int isIn(char str[], int size, char ch);
void append(char *dst, char ch);
char* check(char* str);
char* substr(char* str, int start, int end);
struct Position findPosition(char ch);
char findChar(struct Position pos);
char moveLeft(struct Position pos);
char moveRight(struct Position pos);
char moveUp(struct Position pos);
char moveDown(struct Position pos);
struct Position findOppositeSite(struct Position target, struct Position helper);

static char table[5][5];
static char key[300];
static bool alpha[ALPHA_NUM];

int main() {

	char choose;

	printf("플레이페어 암호화/복호화 프로그램입니다.\n");

	while (1) {
		printf("1: 암호화, 2: 복호화, Q: 종료 >> ");
		scanf(" %c", &choose);

		if (toupper(choose) == 'Q') {
			break;
		}

		switch(choose) {
			case '1':
				printf("암호화를 시작합니다.\n");
				PlayfairEncrypt();
				break;
			case '2':
				printf("복호화를 시작합니다.\n");
				PlayfairDecrypt();
				break;
		}
	}

	return 0;
}

void PlayfairEncrypt() {

	int i, j;

	char* plain = (char*)malloc(sizeof(char) * 100);      // 암호화할 평문
	char* cipherText = (char*)malloc(sizeof(char) * 100); // 암호문
	char* keyDontOverlapWithTheAlpha;

	printf("암호화할 메시지를 입력하세요(공백, 특수문자, 숫자 X): ");
	scanf("%s", plain);

	printf("키: ");
	scanf("%s", key);

	strupr(key);
	strupr(plain);

	keyDontOverlapWithTheAlpha = eliminateDuplicatedAlpha(key, strlen(key));

	// alpha 배열을 초기화한다.
	for (i = 0; i < ALPHA_NUM; i++) {
		alpha[i] = false;
	}

	// 입력받은 문자열부터 테이블에 적용한다.
	makeTable(keyDontOverlapWithTheAlpha);

	printf("키 테이블\n");

	for (i = 0; i < 5; i++) {
		for(j = 0; j < 5; j++) {
			printf(" %c", table[i][j]);
		}
		printf("\n");
	}

	char* checkedText;

	// 플레이페어 암호화 알고리즘
	checkedText = check(plain);

	for (i = 0; checkedText[i] != '\0'; i += 2) {
		char c1 = checkedText[i];
		char c2 = checkedText[i + 1];

		struct Position posOfC1 = findPosition(c1);
		struct Position posOfC2 = findPosition(c2);

		// 1. 두 문자가 같은 행에 있는 경우
		if (posOfC1.x == posOfC2.x) {
			append(cipherText, moveRight(posOfC1));
			append(cipherText, moveRight(posOfC2));
		}

		// 2. 두 문자가 같은 열에 있는 경우
		else if (posOfC1.y == posOfC2.y) {
			append(cipherText, moveDown(posOfC1));
			append(cipherText, moveDown(posOfC2));
		}

		// 3. 두 문자가 서로 다른 행렬에 있는 경우
		else {
			struct Position oppositeSiteForC1 = findOppositeSite(posOfC1, posOfC2);
			struct Position oppositeSiteForC2 = findOppositeSite(posOfC2, posOfC1);
			append(cipherText, findChar(oppositeSiteForC1));
			append(cipherText, findChar(oppositeSiteForC2));
		}
	}

	// 암호화된 문자열 출력
	printf("%s\n", cipherText);
	free(plain);
	free(cipherText);
}

void PlayfairDecrypt() {

	int i, j;

	char* encryptedText = (char*)malloc(sizeof(char) * 100); // 복호화할 암호문
	char* decryptedText = (char*)malloc(sizeof(char) * 100); // 복호화된 평문
	char* keyDontOverlapWithTheAlpha;

	printf("복호화할 암호문을 입력하세요(공백, 특수문자, 숫자 X): ");
	scanf("%s", encryptedText);

	printf("키: ");
	scanf("%s", key);

	strupr(key);
	strupr(encryptedText);

	keyDontOverlapWithTheAlpha = eliminateDuplicatedAlpha(key, strlen(key));

	// alpha 배열을 초기화한다.
	for (i = 0; i < ALPHA_NUM; i++) {
		alpha[i] = false;
	}

	// 입력받은 문자열부터 테이블에 적용한다.
	makeTable(keyDontOverlapWithTheAlpha);

	printf("키 테이블\n");

	for (i = 0; i < 5; i++) {
		for(j = 0; j < 5; j++) {
			printf(" %c", table[i][j]);
		}
		printf("\n");
	}

	char* checkedText;

	// 플레이페어 복호화 알고리즘
	checkedText = check(encryptedText);

	for (i = 0; checkedText[i] != '\0'; i += 2) {
		char c1 = checkedText[i];
		char c2 = checkedText[i + 1];

		struct Position posOfC1 = findPosition(c1);
		struct Position posOfC2 = findPosition(c2);

		// 1. 두 문자가 같은 행에 있는 경우
		if (posOfC1.x == posOfC2.x) {
			append(decryptedText, moveLeft(posOfC1));
			append(decryptedText, moveLeft(posOfC2));
		}

		// 2. 두 문자가 같은 열에 있는 경우
		else if (posOfC1.y == posOfC2.y) {
			append(decryptedText, moveUp(posOfC1));
			append(decryptedText, moveUp(posOfC2));
		}

		// 3. 두 문자가 서로 다른 행렬에 있는 경우
		else {
			struct Position oppositeSiteForC1 = findOppositeSite(posOfC1, posOfC2);
			struct Position oppositeSiteForC2 = findOppositeSite(posOfC2, posOfC1);
			append(decryptedText, findChar(oppositeSiteForC1));
			append(decryptedText, findChar(oppositeSiteForC2));
		}
	}

	// 복호화된 문자열 출력
	printf("%s\n", decryptedText);
	free(encryptedText);
	free(decryptedText);
}

void strupr(char str[]) {
	int i;
	for(i = 0; str[i] != '\0'; i++) {
		str[i] = toupper(str[i]);
	}
}

char* eliminateDuplicatedAlpha(char str[], int size) {
	char* elimedStr = malloc(sizeof(char) * size);
	int i, s = 0;

	for (i = 0; str[i] != '\0'; i++) {
		if(isIn(elimedStr, s, str[i]) == 0) {
			append(elimedStr, str[i]);
			s++;
		}
  }

	return elimedStr;
}

void makeTable(char* key) {

	int i, j, k;

	int row = strlen(key) / 5;
	int col = strlen(key) % 5;

	for (i = 0; i < row; i++) {
		for (j = 0; j < 5; j++) {
			table[i][j] = key[i * 5 + j];
			alpha[table[i][j] - 'A'] = true;
		}
	}

	if(col != 0) {
		for (i = 0; i < col; i++) {
			table[row][i] = key[row * 5 + i];
			alpha[table[row][i] - 'A'] = true;
		}
	}


	// 나머지 알파벳 적용. j는 제외
	alpha['J' - 'A'] = true;

	// 암호문을 입력하고 남은 칸에 알파벳 입력
	for (i = col; i < 5; i++) {
		for(j = 0; j < ALPHA_NUM; j++) {
			if(alpha[j] == false) {
				table[row][i] = j + 'A';
				alpha[table[row][i] - 'A'] = true;
				break;
			}
		}
	}

	for (i = row + 1; i < 5; i++) {
		for(j = 0; j < 5; j++) {
			for(k = 0; k < ALPHA_NUM; k++) {
				if(alpha[k] == false) {
					table[i][j] = k + 'A';
					alpha[table[i][j] - 'A'] = true;
					break;
				}
			}
		}
	}
}

int isIn(char str[], int size, char ch) {

	int i;
	for (i = 0; i < size; i++) {
		if (str[i] == ch)
			return 1;
	}

	return 0;
}

void append(char *dst, char ch) {

    char *p = dst;

    while (*p != '\0') p++; // 문자열 끝 탐색
    *p = ch;
    *(p+1) = '\0';
}

char* check(char* str) {

	int i, j;
	for (i = 0; str[i] != '\0'; i += 2) {
		char c1 = str[i];
		char c2 = str[i + 1];

		if (c1 == c2) {
			char* temp1 = substr(str, 0, i);
			char* temp2 = substr(str, i + 1, strlen(str));
			append(temp1, 'X');
			str = strcat(temp1, temp2);
		}
	}

	if (strlen(str) % 2 == 1)
		append(str, 'X');

	return str;
}

char* substr(char* str, int start, int end) {

	char* temp = (char *)malloc(sizeof(char) * (end - start + 2) + 1);
	strncpy(temp, str + start, end - start + 1);
	temp[end - start + 1] = 0;
	return temp;
}

struct Position findPosition(char ch) {

	struct Position pos;
	int i, j;

	for (i = 0; i < 5; i++) {
		for (j = 0; j < 5; j++) {
			if (table[i][j] == ch) {
				pos.x = i;
				pos.y = j;
				return pos;
			}
		}
	}
}

char findChar(struct Position pos) {
	return table[pos.x][pos.y];
}

char moveLeft(struct Position pos) {

	if(pos.y - 1 < 0)
		return table[pos.x][4];

	return table[pos.x][pos.y - 1];
}

char moveRight(struct Position pos) {

	if(pos.y + 1 >= 5)
		return table[pos.x][0];

	return table[pos.x][pos.y + 1];
}

char moveUp(struct Position pos) {

	if(pos.x - 1 < 0)
		return table[4][pos.y];

	return table[pos.x - 1][pos.y];
}

char moveDown(struct Position pos) {

	if(pos.x + 1 >= 5)
		return table[0][pos.y];

	return table[pos.x + 1][pos.y];
}

struct Position findOppositeSite(struct Position target, struct Position helper) {

	struct Position oppositePosition;

	oppositePosition.x = target.x;
	oppositePosition.y = helper.y;

	return oppositePosition;
}
