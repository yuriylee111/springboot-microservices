package com.lee.organizationservice.service.impl;

import com.lee.organizationservice.dto.OrganizationDto;
import com.lee.organizationservice.entity.Organization;
import com.lee.organizationservice.mapper.OrganizationMapper;
import com.lee.organizationservice.repository.OrganizationRepository;
import com.lee.organizationservice.service.OrganizationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationMapper.mapToOrganizationDto(savedOrganization);
    }

    @Override
    public OrganizationDto getOrganizationByCode(String code) {
        Organization organization = organizationRepository.findByOrganizationCode(code);
        return OrganizationMapper.mapToOrganizationDto(organization);
    }
}
