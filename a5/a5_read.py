#!/usr/bin/python
import os,sys,time

class read_class:
	fd=0
	pipename="aapla_pipe"

	def read(self):
		self.fd=open(self.pipename,'r')
		string_buff=self.fd.read()
		print 'Your String:'
		print string_buff
		revstring=string_buff[::-1]
		print 'See the Magic:'		
		print revstring

object2=read_class()

while True:

	object2.fd=open(object2.pipename,'r')
	choice=object2.fd.read()
	if choice=='1':
		object2.read()
	else:
		break	
