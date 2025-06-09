$(document).ready(function() {
    $('form').on('submit', function(event) {
        const pattern = /^\d{2}[A-Z]\d-\d{5}$/;
        const bienSoXeInput = $('input[name="bienSoXe"]');
        if (!pattern.test(bienSoXeInput.val())) {
            alert('Bien so xe khong dung dinh dang. Dinh dang dung: xxYx-xxxxx');
            event.preventDefault();
        }
    });
});
