#include <iostream>
#include <stdlib.h>
#include <sys/stat.h>

using namespace std;

int main()
{
	system("[ -d /sys/firmware/efi ] && echo UEFI || echo Legacy");

	system("dmidecode -t bios");
	return 0;
	
}
