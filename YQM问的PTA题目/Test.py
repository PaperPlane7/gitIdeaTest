import math


def lock(text,key):
    n = len(key)
    dic = dict()
    str = []
    index = 0
    for j in range(n):
        temp = ""
        for i in range(math.ceil(len(text)/n)):
            index = n*i+j
            if index >=len(text):
                break
            temp += text[index]
        dic[key[j]] = temp
        str.append(temp)
    dicFin = sorted(dic.items(),key=lambda x:x[0])
#   print(dicFin)
    out = ""
    for i in dicFin:
        out += i[1]
    print(out)

lock('canyouunderstand','able')