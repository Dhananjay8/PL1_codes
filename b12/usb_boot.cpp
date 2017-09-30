//enter into root mode before executing the code
#include<iostream>
#include<stdlib.h>
#include<string>
using namespace std;

int main()
{
	cout<<"Displaying the usb device list"<<endl;
	system("lsblk");

	string name;
	cout<<"enter the usb device name as /dev/sdb*"<<endl;
	cin>>name;
	cout<<"\n";
	string unmount="umount "+name;
	cout<<"Unmounting the usb device"<<endl;
	system(unmount.c_str());
	system("lsblk");

	cout<<"Enter the iso filename as filename.iso"<<endl;
	string filename;	
	cin>>filename;
	cout<<"\n";
	
	cout<<"Now copy the iso to usb"<<endl;
	string dd;
	dd="dd if="+filename+" of="+name;
	system(dd.c_str());
	system("sync");
	return 0;
}
