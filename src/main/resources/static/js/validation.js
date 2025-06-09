$(document).ready(function() {
    $('form').on('submit', function(event) {
        const pattern = /^\d{2}[A-Z]\d-\d{5}$/;

        const bienSoXeInput = $('input[name="bienSo"]');
        const bienSoValue = bienSoXeInput.val().trim();

        if (!pattern.test(bienSoValue)) {
            alert('Biển số xe không đúng định dạng. Định dạng đúng: xxYx-xxxxx (ví dụ: 29A3-12345)');
            bienSoXeInput.focus();
            event.preventDefault();
        }
    });
});

