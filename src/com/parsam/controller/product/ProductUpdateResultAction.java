package com.parsam.controller.product;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.parsam.comm.Action;
import com.parsam.comm.Forward;
import com.parsam.dto.ProductDTO;
import com.parsam.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class ProductUpdateResultAction implements Action {
    @Override
    public Forward execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int filesize=1024*1024*100;
        String uploadpath=request.getServletContext().getRealPath("productUpload");
        MultipartRequest multi = new MultipartRequest(request, uploadpath, filesize,"utf-8",new DefaultFileRenamePolicy());

        ProductService service = ProductService.getService();

        long pid = Long.parseLong(multi.getParameter("p_id"));
        String old_pimg = multi.getParameter("old_pimg");
        String new_pimg = multi.getFilesystemName("new_pimg");
        String pname = multi.getParameter("pname");
        int pprice = Integer.parseInt(multi.getParameter("pprice"));
        String pcate = multi.getParameter("pcate");
        int pcnt = Integer.parseInt(multi.getParameter("pcnt"));
        String pdesc = multi.getParameter("pdesc");
        String popenchat = multi.getParameter("popenchat");
        String pstate = multi.getParameter("pstate");
        String ptrade = multi.getParameter("ptrade");
        String pplace = multi.getParameter("pplace");
        long u_id = Long.parseLong(multi.getParameter("u_id"));

        ProductDTO pdto = new ProductDTO();
//        System.out.println(new_pimg+".........new pimg");
//        System.out.println(old_pimg+".........old pimg");

        if(new_pimg != null) { // 새 이미지가 있을 때 (기존 이미지가 있든 없든 일단)
            pdto.setP_img(new_pimg); //새 이미지로 설정
            if (old_pimg != null){ // 새 이미지가 있는데 기존 이미지가 있다면 기존 이미지 productUpload 폴더에서 삭제
                String realpath = request.getServletContext().getRealPath("productUpload");
                String imgpath = realpath+"/"+old_pimg;
                File f = new File(imgpath);
                if (f.isFile()){
                    if (f.exists()){
                        f.delete();
                    }
                }
            }
        } else { // 새 이미지가 없을 때
            if (old_pimg != null){ //기존 이미지가 있을 때
                pdto.setP_img(old_pimg);
            }
            //새 이미지가 없고 기존 이미지도 없으면 아무것도 안넘김(null)
        }

        pdto.setP_id(pid);
        pdto.setP_name(pname);
        pdto.setP_price(pprice);
        pdto.setP_cate(pcate);
        pdto.setP_cnt(pcnt);
        pdto.setP_desc(pdesc);
        pdto.setP_openchat(popenchat);
        pdto.setP_state(pstate);
        pdto.setP_place(pplace);
        pdto.setP_trade(ptrade);
        pdto.setU_id(u_id);

        service.updateData(pdto);

        request.setAttribute("pid",pid);
        Forward forward = new Forward();
        forward.setForward(false);
        forward.setUrl("product_update_alert.do");
        return forward;
    }
}
