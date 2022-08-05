#find real roots of x^2-k=0

def newtonRaphson():
	k=int(raw_input('in equation x^2-k=0 enter k :'))
	epsilon=0.01
	guess=k/2.0
	while(abs(guess*guess-k)>=epsilon):
		guess=guess-(((guess**2)-k)/(2*guess))
	if(squareComplete(k)):
		guess=int(guess)
		print('root is :'+str(guess))
	else:
		print('root is : '+str(guess))
	

def squareComplete(x):
	i=1
	complete=False
	end=False
	while(end!=True):
		if i*i==x:
			return True
		else:
			if i*i<x:
				i=i+1
			else:
				end=True
	return complete

	
	
newtonRaphson()
print('newtown raphson approximation algorithm .')
print('Developed by JR.Y.')
print('----->>> De.Coder()')
