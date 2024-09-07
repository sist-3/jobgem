package com.sist.jobgem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sist.jobgem.dto.BlockDto;
import com.sist.jobgem.repository.BlockRepository;

@Service
public class BlockService {
    @Autowired
    private BlockRepository blockRepository;

    public Page<BlockDto> blackjobseekerList(Pageable pageable, String value, String type) {
        if (value == null && type == null) {
            return blockRepository.blackjobcompany(pageable);
        }
        return blockRepository.findByTypeAndValuejobseekerContaining(type, value, pageable);
    }

    public Page<BlockDto> blackcompanyList(Pageable pageable, String value, String type) {
        if (value == null && type == null) {
            return blockRepository.blackjobcompany(pageable);
        }
        return blockRepository.findByTypeAndValuecompanyContaining(type, value, pageable);
    }
}
