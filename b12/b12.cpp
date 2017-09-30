#include <iostream>
#include <stdlib.h>
#include <string>

using namespace std;

int main()
{
	
	string dev_name,iso_name,command1,command2;
	system("lsblk");

	cout<<"Enter name of the device(/sda/*):";
	cin>>dev_name;
	
	command1="umount "+ dev_name;
	system(command1.c_str());
	system("lsblk");

	cout<<"\nEnter name of the ISO file:";
	cin>>iso_name;

	command2="dd if="+ iso_name +"of=" + dev_name;
	system(command2.c_str());
	system("sync");
	return 0;

}

