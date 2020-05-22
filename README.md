# TSP-Optimization


# Screenshots #

![Alt text](https://github.com/1hbb/TSP-Optimization/blob/master/screenshots/Ekran%20Resmi%202020-05-22%2013.20.08.png "1")



### Gezgin Kargo Problemi ###

Programlama Loboratuarı Bahar Dönemi 1. Proje. Gezgin Kargo Problemi Projesi

# Başlangıç #


Program herhangi bir kargo şirketinin ürünleri çıkış noktasından(dinamik olarak kullanıcı tarafından girilir) müşterilerine
en kısa yoldan ulaştırması için ek kısa 5 yolu bulmaktadır.Problemin çözümünde Floyd-Warshall algoritmaı kullanılmıştır.




# Kurulum & Kullanım #


Program kurulum gerektirmez. Proje klasörü içinde 4 adet klasör bulunmakta.

1) "Intellij IDEA" klasörü projenin Intellij IDE ile uyumlu halidir.
2) "NetBeans" Klasörü projenin NetBeans IDE uyumlu halidir.
3) "Eclipse" klasörü projenin Eclipse IDE ile uyumlu halidir.
4) "JAR" klasörü içerisinde programın "Prolab-2-1.jar" isimli çalıştırılabilir
    java programını barındırır. Çift tıklayarak çalıştırabilirsiniz.


Programı çalıştırdığınızda:
1) ilk olarak kaç adet şehire uğramak istediğinizi girmelisiniz(10 dan büyük olmamalı).  

2) Başlangıç şehrininin plakasını girmelisiniz. Yani kargonun çıkış yeri.

3) Son olarak daha önce sayısını girdiğiniz uğramak istediğiniz şehirlerin plakalarını girmelisiniz.

4) Tüm girdileri girdikten sonra karşınıza iki ayrı pencere çıkacaktır.
 Bunlardan ilki en kısa 5 yolu ve maliyetini ve programın çalışma süresini size gösterecektir.
 Diğer daha büyük olan pencere ise size en kısa 5 yolun bir haritada çizilmiş halini gösterir.




# Gereklilikler #


Sisteminizde Java 14 versionu kurulu olmalıdır.



# Test Sonuçları #

Yapılan testlerde programın karmaşıklık düzeyine göre hesaplama süreleri;

1 şehir için -> 0.067 saniye
2 şehir için -> 0.066 saniye
3 şehir için -> 0.077 saniye
4 şehir için -> 0.068 saniye
5 şehir için -> 0.068 saniye
6 şehir için -> 0.071 saniye
7 şehir için -> 0.081 saniye 
8 şehir için -> 0.138 saniye 
9 şehir için -> 0.550 saniye
10 şehir için -> 3.593 saniye

Dikkat! Süreler donanım durumuna ve rotaya göre değişkenlik gösterebilir.


# Geliştirici #

Harun Burak BURSA
