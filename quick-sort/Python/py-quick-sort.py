
def partition(li,low_idx,hi_idx):
    pivot = li[low_idx]
    i = low_idx +1
    j = hi_idx
    while(i<=j):
        if(li[i]<=pivot):
            i = i+1
        elif(li[j]>pivot):
            j = j-1
        else:
            li[i],li[j] = (li[j],li[i])
            i = i+1
            j = j-1
    li[low_idx],li[j] = li[j],li[low_idx]
    return j



def qsort(li,low_idx,hi_idx):
    if (hi_idx <= low_idx):
        return
    threshhold = partition(li,low_idx,hi_idx)
    qsort(li,low_idx,threshhold-1)
    qsort(li,threshhold+1,hi_idx)


li = [2,7,3,45,34,67,23,25]
li = ["va","ka","pv","ad","ch","ma"]
qsort(li,0,len(li)-1)
print(li)
