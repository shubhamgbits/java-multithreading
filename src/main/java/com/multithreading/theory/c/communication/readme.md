
# Inter Thread Communication

3 important related methods (of OBJECT class)

```dtd
1) .wait()
2) .notify()
3) .notifyAll()

All 3 must be called inside synchronized area
(Thread should be owner of that object 
    i.e. thread should have lock of that object 
    i.e. thread should be inside synchronized area)
```

Q) Why these are present in Object class but not Thread class? Since they will never be used outside of multithreading.
- Because thread can call .wait() method on any Java object (unlike join, yield etc.)
- Similarly .notify() should be available for every java object

If not called from inside synchronized area 
- It will throw *IllegalMonitorStateException*




