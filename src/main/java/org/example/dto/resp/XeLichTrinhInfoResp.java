package org.example.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class XeLichTrinhInfoResp {
    private String maXe;
    private String bienSo;
    private String tenTaiXe;
    private String tenNhaXe;
    private String maTuyen;
    private String tenTuyen;
    private LocalDate ngayXuatBen;
    private LocalTime gioXuatBen;

}

