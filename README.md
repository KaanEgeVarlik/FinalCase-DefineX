# DefineX Java Spring Practicum FinalCase 

Kullanıcıdan alınan veriler ile kredi başvurusunu değerlendirip, kredi limitini belirleyen ve sonucunu SMS olarak dönen bir API oluşturdum.

## Dikkat Edilmesi Gerekenler

- Database bilgileri local bilgisayarımda kullandığım bilgilerdir. Application.properties dosyasında bunları değiştirmelisiniz.
- SMS gönderimi için Twilio kullandım. Ücretsiz versiyonunu kullandığım için verified olmayan telefon numaralarına SMS gönderimi sağlamıyor. Kendi hesabınızı açıp ID ve authtoken'inizi alabilirsiniz. Bunu SMS controller'da değiştirmelisiniz.
- Database'deki verileri saklamak için application.properties'de şu değişikliği yapmayı unutmayın : `spring.jpa.hibernate.ddl-auto=update`
