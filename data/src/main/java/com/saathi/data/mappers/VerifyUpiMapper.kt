package com.saathi.data.mappers

import com.saathi.data.dto.MandateDetailsDto
import com.saathi.data.dto.VerifyUpiDto
import com.saathi.domain.model.MandateDetails
import com.saathi.domain.model.VerifyUpi
import javax.inject.Inject

class VerifyUpiMapper @Inject constructor() {
    fun mapToVerifyUpi(dto: VerifyUpiDto): VerifyUpi {
        return VerifyUpi(
            status = dto.status,
            vpa = dto.vpa,
            mandateDetails = mapMandateDetails(dto.mandateDetails),
            customerName = dto.customerName
        )
    }

    private fun mapMandateDetails(dto: MandateDetailsDto?): MandateDetails? {
        if (dto == null) return null
        return MandateDetails(
            isHandleSupported = dto.isHandleSupported
        )
    }
}