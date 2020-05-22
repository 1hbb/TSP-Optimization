# TSP-OPTIMIZATION


# Screenshots #
![Alt text](https://github.com/1hbb/TSP-Optimization/blob/master/screenshots/Ekran%20Resmi%202020-05-22%2013.22.03.png "3")
![Alt text](https://github.com/1hbb/TSP-Optimization/blob/master/screenshots/Ekran%20Resmi%202020-05-22%2013.20.08.png "1")
![Alt text](https://github.com/1hbb/TSP-Optimization/blob/master/screenshots/Ekran%20Resmi%202020-05-22%2013.20.27.png "2")



### TRAVELLER CARGO PROBLEM ###

Programming Laboratory Spring Semester Project 1 Traveller Cargo Problem 

# INTRODUCTİON #


Program herhangi bir kargo şirketinin ürünleri çıkış noktasından(dinamik olarak kullanıcı tarafından girilir) müşterilerine
en kısa yoldan ulaştırması için ek kısa 5 yolu bulmaktadır.Problemin çözümünde Floyd-Warshall algoritmaı kullanılmıştır.




# INSTALLING & USING #


No setup required. There is 4 folder in "Project" folder.

1) "Intellij IDEA" for direct open with Intellij IDEA.
2) "NetBeans" for direct open with Apache Netbeans.
3) "Eclipse" for direct open with Eclipse IDE.
4) There is an executable java program named "Prolab-2-1.jar" in the "JAR" folder. 
   You can run by double click.
    


Programı çalıştırdığınızda:
1) ilk olarak kaç adet şehire uğramak istediğinizi girmelisiniz(10 dan büyük olmamalı).  

2) Başlangıç şehrininin plakasını girmelisiniz. Yani kargonun çıkış yeri.

3) Son olarak daha önce sayısını girdiğiniz uğramak istediğiniz şehirlerin plakalarını girmelisiniz.

4) Tüm girdileri girdikten sonra karşınıza iki ayrı pencere çıkacaktır.
 Bunlardan ilki en kısa 5 yolu ve maliyetini ve programın çalışma süresini size gösterecektir.
 Diğer daha büyük olan pencere ise size en kısa 5 yolun bir haritada çizilmiş halini gösterir.




# DEPENDENCIES #


Java 14 must be installed on your system. 



# Test Results #

Yapılan testlerde programın karmaşıklık düzeyine göre hesaplama süreleri;

If 1 city will visit -> 0.067 second
If 2 city will visit -> 0.066 saniye
3 şehir için -> 0.077 saniye
4 şehir için -> 0.068 saniye
5 şehir için -> 0.068 saniye
6 şehir için -> 0.071 saniye
7 şehir için -> 0.081 saniye 
8 şehir için -> 0.138 saniye 
9 şehir için -> 0.550 saniye
10 şehir için -> 3.593 saniye

Dikkat! Süreler donanım durumuna ve rotaya göre değişkenlik gösterebilir.


# DEVELOPER #

Harun Burak BURSA
