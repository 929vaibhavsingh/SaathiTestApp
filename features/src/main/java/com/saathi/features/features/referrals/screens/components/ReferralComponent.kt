package com.saathi.features.features.referrals.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.saathi.features.R
import com.saathi.features.component.VerticalSpacers
import com.saathi.features.theme.BlueBg

@Composable
fun ReferAndEarnUi(
    onClickWallet: () -> Unit,
    onClickRefer: () -> Unit,
    onClickTermsCondition: () -> Unit,
    onClickFaq: () -> Unit
) {
    var isPurchase by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .background(color = BlueBg)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        SetWalletIcon(
            isPurchase,
            modifier = Modifier
                .padding(top = 9.dp, end = 16.dp, bottom = 7.dp)
                .align(Alignment.End), onClickWallet
        )
        BlueGradientText(stringResource(R.string.refer_karein_aur))
        VerticalSpacers(8.dp)
        ReferAmountText()
        VerticalSpacers(8.dp)
        DailyEarnText()
        VerticalSpacers(44.dp)
        CourseImage()
        VerticalSpacers(18.dp)
        ReferralUi(isPurchase, {
            isPurchase = true
        },onClickRefer,onClickTermsCondition,onClickFaq)

    }
}

@Composable
private fun ReferralUi(
    isPurchase: Boolean,
    onPurchase: () -> Unit,
    onClickRefer: () -> Unit,
    onClickTermsCondition: () -> Unit,
    onClickFaq: () -> Unit
) {
    if (isPurchase) {
        ReferralLinkUi(onClickRefer,onClickTermsCondition,onClickFaq)
    } else {
        CourseLinkUi(onPurchase)
    }
}



@Composable
private fun SetWalletIcon(isPurchase: Boolean, modifier: Modifier, onClickWallet: () -> Unit) {
    if (isPurchase) {
        Image(
            modifier = modifier.clickable {
                onClickWallet.invoke()
            },
            painter = painterResource(id = R.drawable.ic_wallet), // Replace with your image resource
            contentDescription = stringResource(R.string.earn_100_everytime),
        )
    } else {
        VerticalSpacers(44.dp)
    }
}








@Preview
@Composable
fun ReferralUiPreview() {
    CourseLinkUi {

    }
}