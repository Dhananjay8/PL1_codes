#include <stdio.h>
#include <iostream>
#include <sys/stat.h>

using namespace std;
class Custominode
{	
	char fn[30];
	struct stat buff;
	int status;
  public:
	void getFile();
	void getStatus();
	void getInfo();
	void getTimeinfo();
	void getPermissioninfo();

};

void Custominode::getFile()
{
	cout << "\n Enter the path of the file\n";
	cin >>  fn;
}
void Custominode::getStatus()
{
	status = stat(fn,&buff);
	
	if(status < 0)
	{
		cout <<"\n File doesnot exist...!\n";
	}
	else
	{
		cout <<"\n File exists...!\n";
	}
}
void Custominode::getInfo()
{
	cout<< "\n Inode no : "<< buff.st_ino;
	cout<< "\n Size : "<< buff.st_size;
	cout<< "\n Block size : "<< buff.st_blksize;
	cout<< "\n Group id : "<< buff.st_gid;
	cout<< "\n Device id  : "<< buff.st_dev;
	cout<< "\n NO of hard links : "<< buff.st_nlink;	
	cout<< "\n Mode : "<< buff.st_mode;
	cout<< "\n Block : "<< buff.st_blocks;
}
void Custominode::getTimeinfo()
{
	cout<< "\n Access time : "<< ctime(&buff.st_atime);
	cout<< "\n Modifiaction time : "<< ctime(&buff.st_mtime);
	cout<< "\n Change time : "<< ctime(&buff.st_ctime);
}
void Custominode:: getPermissioninfo()
{
	if (buff.st_mode & S_IRGRP)
		cout <<"\n Read permission to Group";
	if (buff.st_mode & S_IWGRP)
		cout <<"\n Write permission to Group";
	if (buff.st_mode & S_IXGRP)
		cout <<"\n Execute permission to Group";

	if(S_ISREG (buff.st_mode))
		cout<<"\n Regular File";
	else if (S_ISDIR (buff.st_mode))
		cout<<"\n Directory";
	else if (S_ISLNK (buff.st_mode))
		cout<<"\n Symbolic link";
	else if (S_ISBLK (buff.st_mode))
		cout<<"\n Block Device";
	else if (S_ISSOCK (buff.st_mode))
		cout<<"\n Socket";
	else if (S_ISCHR(buff.st_mode))
		cout<<"\n Character file";
}

int main()
{
	Custominode i;
	i.getFile();
	i.getStatus();
	i.getInfo();
	i.getTimeinfo();
	i.getPermissioninfo();
	return 0;
}


