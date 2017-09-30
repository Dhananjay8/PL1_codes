#!/usr/bin/python
import os,sys,time

class write_class:
	fd=0
	pipename="aapla_pipe"

	def create_pipe(self):
		os.mkfifo(self.pipename)

	def write_pipe(self):
		self.fd=open(self.pipename,'w')
		self.fd.write("1")
		self.fd.close()

		string=raw_input("\nString Taak:  ")

		self.fd=open(self.pipename,'w')
		self.fd.write(string)
		self.fd.close()

object1=write_class()
object1.create_pipe()

while True:
	choice=raw_input("\n1]Enter String \n2] GFY\nYour Choice:")
	
	if choice=='1':
		object1.write_pipe()
	else:
		object1.fd=open(object1.pipename,'w')
		object1.fd.write('2')
		object1.fd.close()
		os.unlink(object1.pipename)
		break
