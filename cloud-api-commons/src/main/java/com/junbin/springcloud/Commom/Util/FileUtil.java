package com.junbin.springcloud.Commom.Util;


import com.junbin.springcloud.Commom.exception.BusinessException;
import com.junbin.springcloud.Commom.resultcode.BaseResultCodeEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @ Author     ：苏俊滨
 * @ Date       ：Created in 23:10 2020/2/4
 * @ Description：${description}
 **/
public class FileUtil {

    public static final String RootDir  = "/home/Upload_File/";


    public static final String Path = "/Upload_File/";

    /**
     * 创建文件
     * @param file
     * @throws IOException
     */
    public static String CreateFile(MultipartFile file)  {

        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(RootDir + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
           throw new BusinessException(BaseResultCodeEnum.RUNTIME_EXCEPTION,"文件上传失败");
        }
        return fileName;

    }

    /**
     * 跟新文件
     * @param file
     * @param filepath
     * @return
     */
    public static String UpdateFile(MultipartFile file, String filepath)
    {
        File Oldfile = new File(RootDir+filepath);
        if(!Oldfile.getParentFile().exists())
        {
            Oldfile.getParentFile().mkdirs();
        }
        try {
            file.transferTo(Oldfile);
        }catch (IOException e)
        {
            throw new BusinessException(BaseResultCodeEnum.RUNTIME_EXCEPTION,"文件跟新失败");
        }
        return filepath;
    }


    /**
     *
     * 删除文件
     * @param filepath
     *
     * @return
     */
    public static void RemoveFile(String filepath) {

        filepath.replace(Path, RootDir);
        File Oldfile = new File(filepath);
        if(!Oldfile.delete()) {
            throw new BusinessException(BaseResultCodeEnum.RUNTIME_EXCEPTION, "文件删除失败");
        }


    }
}
