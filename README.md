Operasi CRUD dengan PostgreSQL dan Java

Deskripsi tugas
Pada tugas Pemrograman Berbasis Objek (PBO) pertemuan 4 ini yaitu mengimplementasikan operasi CRUD (Create, Read, Update, Delete)
menggunakan Java dan database PostgreSQL, dengan database PESANAN. Proyek ini mencakup menampilkan, menambah, menghapus, dan mengupdate data pesanan.
Selain itu, saya juga membedakan penggunaan Exception throws dan try-catch, serta menggunakan NumberFormatException untuk melihat hasil output exception keduanya.
Saya juga membuat custom exception dengan nama RiaException untuk mengelola skenario pengecualian tertentu.

CRUD (Create, Read, Update, Delete)
CRUD merupakan empat operasi dasar yang digunakan dalam aplikasi basis data dan pemrograman yang melibatkan manipulasi data. Berikut untuk penjelasannya :

1. Create (membuat) : Operasi create digunakan untuk menambahkan data baru ke dalam database. Dalam aplikasi, ini biasanya melibatkan pengiriman informasi
(dalam SQL menggunakan perintah INSERT).
2. Read (membaca) : Operasi Read digunakan untuk mengambil atau membaca data dari database. Tujuannya adalah untuk melihat atau menampilkan data yang
sudah ada di sistem (dalam SQL menggunakan perintah SELECT).
3. Update (memperbarui) : Operasi Update digunakan untuk mengubah data yang sudah ada di database. Dengan kata lain, operasi ini memungkinkan pengguna 
untuk memperbarui informasi yang sudah disimpan sebelumnya (dalam SQL menggunakan perintah UPDATE).
4. Delete (menghapus) : Operasi Delete digunakan untuk menghapus data dari database. Ini dapat dilakukan ketika data tidak lagi relevan atau diperlukan 
(dalam SQL menggunakan perintah DELETE).

Custom Exception
Custom Exception adalah pengecualian (exception) yang didefinisikan oleh pengguna untuk menangani situasi atau kondisi tertentu yang 
tidak tercakup oleh pengecualian bawaan Java seperti NullPointerException atau ArithmeticException. Membuat custom exception memungkinkan kita untuk 
menangani kasus-kasus spesifik dalam aplikasi kita secara lebih terorganisir dan sesuai dengan kebutuhan. Dalam program yang saya buat, 
saya memberikan nama custom exception dengan nama ElaException yang merupakan custom exception yang didefinisikan oleh pengguna untuk situasi khusus. 
Cara Membuat Custom Exception yaitu :
1. Mewarisi dari Exception atau RuntimeException : Custom exception dapat dibuat dengan mewarisi kelas Exception (untuk pengecualian checked)
atau RuntimeException (untuk pengecualian unchecked).
2. Menyediakan Konstruktor : Dalam suatu class Exception dapat menambahkan berbagai konstruktor untuk exception, seperti konstruktor default dan 
konstruktor yang menerima pesan atau penyebab kesalahan.

Exception Handling
Apa itu Exception? Exception adalah kesalahan (error) atau situasi yang tidak terduga yang terjadi saat program berjalan. Contoh umum dari exception adalah:

1. Pembagian dengan angka nol.
2. Mengakses elemen array di luar batas.
3. Gagal membuka file karena file tidak ditemukan. Di Java, saat exception terjadi, program akan berhenti secara normal kecuali kita menangani exception tersebut.
Apa itu Throws? Kata kunci throws digunakan dalam deklarasi metode untuk menunjukkan bahwa metode tersebut mungkin memunculkan (throw) exception. 
Namun, metode yang menggunakan throws tidak menangani exception di dalamnya. Sebaliknya, exception tersebut harus ditangani oleh kode yang memanggil metode tersebut.

Apa itu Try Catch? try-catch adalah cara untuk menangani exception di dalam program agar program tidak langsung berhenti ketika terjadi error. Dalam blok try,
kita menempatkan kode yang mungkin menghasilkan exception. Jika terjadi exception, Java akan melompat ke blok catch untuk menangani kesalahan tersebut.

Ringkasan
Dalam penugasan kali ini sudah dapat diambil beberapa kesimpulan mulai dari connection postgresql kedalam Netbeans, operasi CRUD dalam Java,
implementasi Custom Exception, dan mengetahui perbedaan dari Exception Try Catch dan Throws. Berikut pemaparan singkatnya mengenai materi yang sudah dijelaskan :

1. Exception: Kesalahan atau situasi tidak terduga saat program berjalan.
2. try-catch: Digunakan untuk menangani exception. Blok try mencoba menjalankan kode yang mungkin menghasilkan error, dan blok catch menangani error tersebut.
3. throws: Digunakan dalam deklarasi metode untuk menyatakan bahwa metode tersebut dapat melempar exception, tetapi penanganan exception harus dilakukan oleh pemanggil metode.
4. Custom Exception: Exception yang dibuat oleh programmer untuk menangani kesalahan atau situasi spesifik sesuai dengan logika aplikasi. Custom exception dibuat dengan mewarisi class Exception.
5. CRUD merupakan empat operasi dasar yang digunakan dalam aplikasi basis data dan pemrograman yang melibatkan manipulasi data mulai dari INSERT, SELECT, UPDATE, dan DELETE.
