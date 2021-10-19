package uz.pdp.springbootjpa.utills;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class CommonUtills {

    public static boolean validatePageSize(int page,int size){
        if (page<0){
            return false;
        }
        else if (size>AppConstatnce.MAX_PAGE_SIZE){
            return false;
        }
        else {
            return true;
        }
    }

    public static Pageable simplePageable(int page,int size){
        if (validatePageSize(page, size)){
            return PageRequest.of(page, size);
        }
        return null;
    }
    public static Pageable byIdAscPageable(int page,int size){
        if (validatePageSize(page, size)){
            return PageRequest.of(page, size, Sort.Direction.ASC,"id");
        }
        return null;
    }
    public static Pageable byIdDescPageable(int page,int size){
        if (validatePageSize(page, size)){
            return PageRequest.of(page, size,Sort.Direction.DESC,"id");
        }
        return null;
    }
}
