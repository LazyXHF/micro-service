package com.mgt.common.exception.file;

import org.apache.commons.fileupload.FileUploadException;

/**
 * @program: mgt-contrl-platform
 * @description: 文件名超长判断
 * @author: Mr.Gu
 * @create: 2019-02-27 12:27
 **/
public class FileNameLengthLimitExceededException extends FileUploadException
{
    private static final long serialVersionUID = 1L;
    private int length;
    private int maxLength;
    private String filename;

    public FileNameLengthLimitExceededException(String filename, int length, int maxLength)
    {
        super("file name : [" + filename + "], length : [" + length + "], max length : [" + maxLength + "]");
        this.length = length;
        this.maxLength = maxLength;
        this.filename = filename;
    }

    public String getFilename()
    {
        return filename;
    }

    public int getLength()
    {
        return length;
    }

    public int getMaxLength()
    {
        return maxLength;
    }
}
