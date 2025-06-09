$(document).ready(function(){
  $('form').on('submit', function(e){
    var valid = true;
    var form = $(this);
    var phone = form.find('input[name$="sodt"]');
    if(phone.length && !/^(090\d{7}|091\d{7}|\(84\)\+90\d{7}|\(84\)\+91\d{7})$/.test(phone.val())){
      alert('Số điện thoại không hợp lệ');
      valid = false;
    }
    var email = form.find('input[type="email"]');
    if(email.length && !/^\S+@\S+\.\S+$/.test(email.val())){
      alert('Email không hợp lệ');
      valid = false;
    }
    var soLuong = form.find('input[name$="soLuong"],input[name$="thoiGianSuDung"],input[name$="donGia"]');
    soLuong.each(function(){
      if($(this).val() && !/^[1-9]\d*$/.test($(this).val())){
        alert('Giá trị phải là số nguyên dương');
        valid = false;
      }
    });
    var gio = form.find('input[type="time"]');
    gio.each(function(){
      if($(this).val() && !/^([01]\d|2[0-3]):[0-5]\d$/.test($(this).val())){
        alert('Định dạng giờ không hợp lệ');
        valid = false;
      }
    });
    var maKH = form.find('input[name$="maKH"]');
    if(maKH.length && !/^KH\d{3}$/.test(maKH.val())){
      alert('Mã KH không hợp lệ');
      valid = false;
    }
    var maDV = form.find('input[name$="maDV"]');
    if(maDV.length && !/^DV\d{3}$/.test(maDV.val())){
      alert('Mã DV không hợp lệ');
      valid = false;
    }
    var bienSo = form.find('input[name$="bienSoXe"]');
    if(bienSo.length && !/^\d{2}[A-Z]\d-\d{5}$/.test(bienSo.val())){
      alert('Biển số xe không hợp lệ');
      valid = false;
    }
    if(!valid){
      e.preventDefault();
    }
  });

  $('.delete-link').on('click', function(e){
    if(!confirm('Bạn có chắc muốn xóa?')){
      e.preventDefault();
    }
  });
});
