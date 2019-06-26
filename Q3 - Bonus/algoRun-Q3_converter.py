from csv import reader

def main():
    data=dict()
	#Read the csv file.
    with open("player_pool.csv", "r") as fil:
        read=reader(fil)
	
        for line in read:
		#Get the strings from the first line of the csv file, then lower than to syncronize them with our .java code.
            for i in range(10, 57):
                data[line[i].lower()]=i
			#Print every strings and their indexes to ease our coding.
                print(line[i].lower(), i)
		#We only need it once.
            break
    ad = ""
    while True:
	#Get the java code.
        ad = input().lower().split("+")
        res=""
        for fra in ad:
		#Now convert it if it is compatible with this code's structure. Else continue to the next part splitted with +.
            try:
                res += "data["+str(data[fra[0:3]]-9)+"]"+fra[3:6]+"+"
            except:
                continue
	#Print the converted code
        print(res)

main()