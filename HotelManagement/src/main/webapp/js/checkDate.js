document.addEventListener('DOMContentLoaded', function() {
    // Lấy ngày hiện tại
    const today = new Date().toISOString().split('T')[0];
    // Đặt min cho checkInDate là ngày hiện tại
    document.getElementById('checkInDate').setAttribute('min', today);

    // Lắng nghe sự kiện thay đổi trên checkInDate
    document.getElementById('checkInDate').addEventListener('change', function() {
        const checkInDate = this.value; // Lấy giá trị ngày check-in
        if (checkInDate) {
            // Đặt min cho checkOutDate là ngày check-in
            document.getElementById('checkOutDate').setAttribute('min', checkInDate);
            // Optional: Xóa giá trị checkOutDate nếu nó nhỏ hơn checkInDate
            const checkOutDateInput = document.getElementById('checkOutDate');
            if (checkOutDateInput.value && checkOutDateInput.value < checkInDate) {
                checkOutDateInput.value = ''; // Xóa giá trị không hợp lệ
            }
        }
    });
});