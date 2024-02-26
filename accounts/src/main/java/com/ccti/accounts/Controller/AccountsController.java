package com.ccti.accounts.Controller;

import com.ccti.accounts.dto.CustomerAccountDto;
import com.ccti.accounts.dto.CustomerDto;
import com.ccti.accounts.dto.ResponseDto;
import com.ccti.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@AllArgsConstructor
@RestController
@RequestMapping(path = "/api/v1", produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private IAccountService iAccountService;
    @GetMapping("hello")
    public String helloEndPoint(){
        return "Hola desde Microservicios !!!";
    }

    @GetMapping("dateTime")
    public String dateTime(){
        return LocalDateTime.now().toString();
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccounts(@RequestBody CustomerDto customerDto){
        iAccountService.createAccount(customerDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "La cuenta ha sido creada correctamente !!"));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerAccountDto> fetchAccount(@RequestParam String email){
        CustomerAccountDto customerAccountDto = iAccountService.fetchAccount(email);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(customerAccountDto);
    }

    @PostMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCustomerAccount(@RequestParam String email){
        boolean res = iAccountService.deleteAccount(email);
        if(res) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto("200", "El cliente ha sido eliminado correctamente !!"));
        }else{
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto("500", "Hubo un error al eliminar el cliente !!"));
        }
    }
}
