# Ticket Booking App 🎟️

Aplikasi sederhana berbasis **Jetpack Compose** untuk simulasi pemesanan tiket.  
Pengguna dapat melihat harga tiket, mengatur jumlah tiket yang ingin dipesan, melihat total pembayaran secara otomatis, dan mengembalikan jumlah tiket ke kondisi awal.

## Deskripsi

Project ini dibuat untuk menerapkan konsep **event handling** dan **state management** pada Jetpack Compose.

Tampilan aplikasi menggunakan pendekatan deklaratif, sehingga perubahan pada jumlah tiket akan langsung memperbarui informasi jumlah tiket dan total pembayaran melalui proses **recomposition**.

## Fitur

- 🎟️ **Menampilkan Harga Tiket**  
  Menampilkan harga satu tiket sebesar **Rp25.000**.

- ➕ **Menambah Jumlah Tiket**  
  Tombol `+` digunakan untuk menambah jumlah tiket yang ingin dipesan.

- ➖ **Mengurangi Jumlah Tiket**  
  Tombol `-` digunakan untuk mengurangi jumlah tiket. Jumlah tiket dibatasi minimal **1 tiket**.

- 💰 **Menghitung Total Pembayaran Otomatis**  
  Total pembayaran akan berubah secara otomatis berdasarkan jumlah tiket yang dipilih.

- 🔄 **Reset Jumlah Tiket**  
  Tombol **Reset Pesanan** digunakan untuk mengembalikan jumlah tiket ke kondisi awal, yaitu **1 tiket**. Total pembayaran juga otomatis kembali menjadi **Rp25.000**.
