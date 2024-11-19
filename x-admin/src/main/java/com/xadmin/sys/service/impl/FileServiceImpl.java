package com.xadmin.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xadmin.sys.entity.Files;
import com.xadmin.sys.mapper.FileMapper;
import com.xadmin.sys.service.IFileService;
import com.xadmin.sys.service.IMenuService;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, Files> implements IFileService {
}
