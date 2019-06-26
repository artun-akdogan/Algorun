import xlrd
from csv import reader

def main():
    workbook = xlrd.open_workbook("valid_submissions.xlsx")

#ata is the ancestor array of data because of time issues.
    ata = []
#read the csv file, nothing special.
    with open("player_pool.csv", 'r') as fil:
        read = reader(fil)
        for line in read:
#Now, get all the positions a player can get.
            temp=[list(line[2].split("||"))]
            for i in range(10, 57):
#As line 0 contains non-integer value, the program must check it.
                try:
                    int(line[i])
                except:
                    break
#Add value to temporary array then add it to REAL ata to make 2-D array.
                temp.append(int(line[i]))
            ata.append(temp)
        
#values of first 3.
    max1=0
    max2=0
    max3=0
#indexes of first 3.
    p1=0
    p2=0
    p3=0
#points array will hold all teams points. Unneccesary in the purpose of this code, but may become important if the code will be modified.
#As there are 23 teams, the array and range of the loop will be 23.
    points = [0 for _ in range(23)]
    for ind in range(23):
#xlrd file read operations.
        sheet = workbook.sheet_by_index(ind)
        i=0
        for rowx in range(sheet.nrows):
	#Only get player id
            idd = sheet.row_values(rowx)[0]
        #Check if idd is integer
            try:
                int(idd)
            except: continue
		#data value inherits ata's values of the player.
            data=ata[int(idd)]
            for pl in ata[int(idd)][0]:
			#Add 1 to i for getting the average point.
                i+=1
				#Calculating the player positions acording to our data in Q1. Used the converter.py to collect the data bellow.
                if pl == "STC":
                    points[ind] += data[25]*3+data[9]*6+data[7]*4+data[35]*4+data[16]*3+data[33]*3+data[18]*6+data[6]*4+data[31]*8
                elif pl == "AML" or pl == "AMR":
                    points[ind] += data[7]*5+data[15]*6+data[16]*3+data[33]*5+data[18]*6+data[6]*6+data[31]*1+data[29]*4+data[8]*4
                elif pl =="MC":
                    points[ind] += data[25]*4+data[8]*4+data[13]*3+data[7]*7+data[15]*7+data[35]*7+data[10]*5+data[29]*4+data[33]*3
                elif pl == "DM":
                    points[ind] += data[25]*4+data[8]*4+data[13]*3+data[7]*7+data[15]*7+data[35]*7+data[10]*5+data[29]*5+data[33]*6+data[18]*5+data[16]*4
                elif pl == "DC":
                    points[ind] += data[25]*7+data[8]*7+data[9]*7+data[13]*4+data[7]*4+data[15]*4+data[35]*7
                elif pl=="DR" or pl== "DL":
                    points[ind] += data[8]*9+data[13]*6+data[7]*5+data[15]*5+data[35]*7+data[33]*4+data[10]*4
                elif pl == "GK":
                    points[ind] +=data[47]*3+data[13]*3+data[45]*9+data[27]*7+data[12]*9+data[24]*5+data[35]*4+data[21]*3+data[22]*3

	#Get the average.
        points[ind] /= i
	#Check if first 3 will change.
        if(max1<points[ind]):
            max3=max2
            p3=p2
            max2=max1
            p2=p1
            max1=points[ind]
            p1=ind
        elif(max2<points[ind]):
            max3=max2
            p3=p2
            p2=ind
            max2=points[ind]
        elif(max3<points[ind]):
            p3=ind
            max3=points[ind]
#After the calculations, print out the first 3 player's index.
    print(p1, p2, p3)

main()