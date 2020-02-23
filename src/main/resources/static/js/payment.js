
    $("#check_module").click(function () {
        const IMP = window.IMP; // 생략해도 괜찮습니다.
        IMP.init("imp84158732");
        var msg;
        IMP.request_pay({
            pg: "kakaopay",
            pay_method: 'card',
            merchant_uid: 'merchant_' + new Date().getTime(),
            name: '주문명:결제테스트',
            amount: 1,
            buyer_email : "{{user.email}}",
            buyer_name : "{{user.name}}",
            buyer_tel : "{{user.phoneNumber}}",
            buyer_addr : "{{#user.addressList}}{{address}}{{/user.addressList}}",
            buyer_postcode : '03462'
        }, function (rsp) {
            if (rsp.success) {
                var msg = '결제가 완료되었습니다.';
                msg += '고유ID : ' + rsp.imp_uid;
                msg += '상점 거래ID : ' + rsp.merchant_uid;
                msg += '결제 금액 : ' + rsp.paid_amount;
                msg += '카드 승인번호 : ' + rsp.apply_num;
            } else {
                var msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
            }

            alert(msg);
        })
    });
