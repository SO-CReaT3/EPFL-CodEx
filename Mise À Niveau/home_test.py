L = [10, 20, 30]
t = ("a", "b", "c")

print({x:y for x in L for y in t}, end="\n\n")

print(dict([(10, "a"), (20, "b"), (30, "c")]))
print(dict([[10, "a"], [20, "b"], [30, "c"]]))
print(dict(([10, "a"], [20, "b"], [30, "c"])))
print(dict(((10, "a"), (20, "b"), (30, "c"))))

print()

a, b, c = [1,2,3]
print(a,b,c, end="\n\n")

L1 = 1,2,3,4,5,6,7,8,9
a, *b, c, e = L1
print(a,b,c,e, f"- type de b: {type(b)}, type de L1: {type(L1)}", end="\n\n")

def shinanigans(*weird):
    return(type(weird))

print(shinanigans(2, 34, "has"))

def shinanigans2(**weird):
    return(weird, type(weird))

print(shinanigans2(y = 4, x = "haha"), end="\n\n")