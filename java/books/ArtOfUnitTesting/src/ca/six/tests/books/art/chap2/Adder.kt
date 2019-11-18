package ca.six.tests.books.art

class Adder {
    private var sum = 0

    fun add(num: Int) {
        sum += num
    }

    // 求和, 并置0
    fun sum(): Int {
        val ret = sum
        sum = 0
        return ret
    }
}

fun main() {
    var value = """ "oebps/brow_9780385537865_epub_ata_r1.htm":"iIWnBaJLiVOzXsBMYEkGsA==",  "oebps/brow_9780385537865_epub_c08_r1.htm":"sdXyJdBYDHRxe42KD3mHjg==",  "oebps/brow_9780385537865_epub_cvi_r1.htm":"jW1C6IzHPe3vHIfc8pjiSA==",  "oebps/images/brow_9780385537865_epub_003_r1.jpg":"4vzDWO0k6U3FXlA/LsHuMw==",  "oebps/fonts/charissilr.ttf":"fxUthxq9xzk4UsuoCwxvSA==",  "oebps/images/brow_9780385537865_epub_001_r1.jpg":"DnRXjEQuS2XwUMerMOnbqw==",  "oebps/images/brow_9780385537865_epub_002_r1.jpg":"VtZh5yw+FHCQWK409GvmrQ==",  "oebps/brow_9780385537865_epub_c06_r1.htm":"z0QnMMr0zeE3LZG82U4VfQ==",  "oebps/brow_9780385537865_epub_prl_r1.htm":"YHVEU2n03+ec5nxjAzmSaQ==",  "oebps/images/brow_9780385537865_epub_l03_r1.jpg":"Yb9QWDS9fqxyNCs5xPS6iQ==",  "oebps/brow_9780385537865_epub_c05_r1.htm":"3ujKKfEJ0vmAtYRqXuPkvg==",  "oebps/brow_9780385537865_epub_c07_r1.htm":"WkSXZl/QG72N6XDVfaQG/Q==",  "oebps/brow_9780385537865_epub_c09_r1.htm":"MDb+Tz1NDY2FWdzLXI5puQ==",  "oebps/images/brow_9780385537865_epub_l02_r1.jpg":"Q3EvL16/oFbDxxmIKN5ujg==",  "oebps/images/brow_9780385537865_epub_l04_r1.jpg":"Z9sz2T9zX2HZg6FSFKqDWQ==",  "oebps/brow_9780385537865_epub_c01_r1.htm":"imTmMHDTmC+1NsOtk+fUeQ==",  "oebps/brow_9780385537865_epub_c02_r1.htm":"LWU3Ht55IG2K+BNYqiCqeQ==",  "oebps/brow_9780385537865_epub_c03_r1.htm":"DQjN6bJpSJ8qrynGWlkttg==",  "oebps/brow_9780385537865_epub_c04_r1.htm":"jfIfh4woRBjFk5IZLmrPMg==",  "oebps/brow_9780385537865_epub_c49_r1.htm":"nu9yuTcr/CFJxvWvXAxeGA==",  "oebps/images/brow_9780385537865_epub_006_r1.jpg":"j9uPZHCOeIgvy9Y8rVZUcA==",  "oebps/brow_9780385537865_epub_c74_r1.htm":"DOL/Vf9JUnm/bDvRSQHyLA==",  "oebps/brow_9780385537865_epub_c83_r1.htm":"oe0Y34klv72irSo+e6q1eA==",  "oebps/brow_9780385537865_epub_c47_r1.htm":"3EQ6I+q+rNj6m3HlwMpHlw==",  "oebps/brow_9780385537865_epub_c76_r1.htm":"DH8bgTeVy6+0JLO/1wTQqQ==",  "oebps/brow_9780385537865_epub_c81_r1.htm":"vHBMw0E67SJyutY3/8A7Ug==",  "oebps/images/brow_9780385537865_epub_004_r1.jpg":"J8GlAIQPMFn1iDVsdQ0ESA==",  "oebps/brow_9780385537865_epub_c72_r1.htm":"aliwIUNTD3pmN7f4Fe+kQQ==",  "oebps/brow_9780385537865_epub_c45_r1.htm":"ljaaE7V0aImDQzCo+rIu4A==",  "oebps/brow_9780385537865_epub_toc_r1.htm":"vuodqh6dSKciBU+GfHkFpA==",  "oebps/fonts/charissili.ttf":"ez9APV/p6sKIvyn2fg6wtw==",  "oebps/brow_9780385537865_epub_c85_r1.htm":"iPcvJ0W57XqeoHdxyRxG7A==",  "oebps/brow_9780385537865_epub_c87_r1.htm":"GuAD8jxTlAKNQ19S01l6dQ==",  "oebps/brow_9780385537865_epub_c34_r1.htm":"BCKFpzRRjsm1NsHxwOaoZw==",  "oebps/brow_9780385537865_epub_c36_r1.htm":"6MSGD7Hgyr3Rt5r1pv8euw==",  "oebps/brow_9780385537865_epub_c38_r1.htm":"rtVbieZ4vYSB78nzVSexMQ==",  "oebps/brow_9780385537865_epub_c102_r1.htm":"TMzpVeja0q19iW3alGNlQA==",  "oebps/brow_9780385537865_epub_c104_r1.htm":"FDrHQkAVc4Aex/KfA44YRA==",  "oebps/brow_9780385537865_epub_c41_r1.htm":"KyD/45BtmXgrArXyG70uBw==",  "oebps/brow_9780385537865_epub_c89_r1.htm":"UmzYm5G8q7nTm5gVIZD0yw==",  "oebps/brow_9780385537865_epub_c43_r1.htm":"0ILZpxZwTHG06OqbYOyvTA==",  "oebps/brow_9780385537865_epub_c78_r1.htm":"/cDyroJMrcvsMSNtzFpOhQ==",  "oebps/brow_9780385537865_epub_c70_r1.htm":"Fv4dtErjgWMFmpqZUHmzPA==",  "oebps/images/brow_9780385537865_epub_tp_r1.jpg":"FYpNyjOT89fPuPHk7l62yQ==",  "oebps/brow_9780385537865_epub_c10_r1.htm":"LsqZgH7AHo+GVGemxTJvwg==",  "oebps/brow_9780385537865_epub_c11_r1.htm":"4jkXtwT4HI+T1fvhuLVL3A==",  "oebps/brow_9780385537865_epub_c100_r1.htm":"GCt87PewZE1I6gkVFZnNKg==",  "oebps/brow_9780385537865_epub_c32_r1.htm":"FxIaTafJj/vF2VIWcaP3AQ==",  "oebps/brow_9780385537865_epub_c18_r1.htm":"tVHW5UylYijthk1cWmPQQg==",  "oebps/brow_9780385537865_epub_c14_r1.htm":"3FIhIvOlsnk8Qm79JnGQqA==",  "oebps/brow_9780385537865_epub_c15_r1.htm":"bKBMLfjJkoMk6/ToSoEc/g==",  "oebps/brow_9780385537865_epub_c19_r1.htm":"GuW3irmq3yGWAR5S/unhQw==",  "oebps/brow_9780385537865_epub_epl_r1.htm":"+7L/0XLkZCHpJTmVukPdRA==",  "oebps/fonts/charissilbi.ttf":"5s7YODFaEbjfkqFj6kdS3g==",  "oebps/brow_9780385537865_epub_c66_r1.htm":"FzXKRb/Hno42wSuafTRHDw==",  "oebps/brow_9780385537865_epub_c91_r1.htm":"a5HZOuaIonwQQeVPVuBv0A==",  "oebps/images/brow_9780385537865_epub_007_r1.jpg":"0SU8dxiJIWFP288F4eEo8w==",  "oebps/brow_9780385537865_epub_c59_r1.htm":"2xb40gXcpgyJ6cfKdZhKgw==",  "oebps/brow_9780385537865_epub_c84_r1.htm":"htao19vbuz4gkpOFM79FQQ==",  "oebps/brow_9780385537865_epub_c73_r1.htm":"tK6suAmd7oUfyTS3LIeN3Q==",  "oebps/brow_9780385537865_epub_c48_r1.htm":"3348nEL6WphgVT7NJBWG3g==",  "oebps/brow_9780385537865_epub_c77_r1.htm":"KeQ7YlPM0Ln5WafS0MycUg==",  "oebps/brow_9780385537865_epub_c37_r1.htm":"YzKsWlBDXPHy2kimkehoJA==",  "oebps/brow_9780385537865_epub_c95_r1.htm":"ZpQv/ELZX35uP67g1MB4Ew==",  "oebps/brow_9780385537865_epub_c80_r1.htm":"blpGZ69Ondw3YqlJsELZpw==",  "oebps/brow_9780385537865_epub_c88_r1.htm":"bzM4+/usPiLdmpdjea9scw==",  "oebps/page-template.xpgt":"cF5aTPw7XYaRJ/7jHfzpaQ==",  "oebps/brow_9780385537865_epub_c103_r1.htm":"zAM3QmNbbFtFGqucJ5iqBA==",  "oebps/brow_9780385537865_epub_c33_r1.htm":"alKofBqK00sSAqLdDZV/gg==",  "oebps/brow_9780385537865_epub_c51_r1.htm":"9S7mm+cZbMMYjAspFXYacg==",  "oebps/brow_9780385537865_epub_c40_r1.htm":"8vcbiwxvY91RGFXVtubOlg==",  "oebps/brow_9780385537865_epub_c44_r1.htm":"i4ry//VrCCKWg6JgFnD+uw==",  "oebps/brow_9780385537865_epub_c62_r1.htm":"OBvQnQhYqH8iaPpCb7iIcw==",  "oebps/brow_9780385537865_epub_c55_r1.htm":"roc28AbCHOt7apVrNwtE2A==",  "oebps/brow_9780385537865_epub_cop_r1.htm":"H4/bMOl9eZ/sVbfQGKFKgQ==",  "oebps/brow_9780385537865_epub_c21_r1.htm":"xenSaTfJzyQHFEZhj5TL9Q==",  "oebps/brow_9780385537865_epub_c20_r1.htm":"0pbFYrzf4EFaHbRXBoCg/Q==",  "oebps/brow_9780385537865_epub_c22_r1.htm":"0By0gzU1oi2+ENNVoO3zRQ==",  "oebps/brow_9780385537865_epub_c25_r1.htm":"Dkv1S7NDialNTcEwb+cS1Q==",  "oebps/brow_9780385537865_epub_c98_r1.htm":"x0HXERtvIyugfGBx5TR3iw==",  "oebps/brow_9780385537865_epub_c99_r1.htm":"u1ZlZe3l5apgpZEpnY9O8Q==",  "oebps/brow_9780385537865_epub_c24_r1.htm":"qNxhrGgGFO0bzAvfhGE7og==",  "oebps/brow_9780385537865_epub_fm1_r1.htm":"nAMvmXrRSJ8/EnZwJMLuDg==",  "oebps/brow_9780385537865_epub_c26_r1.htm":"YjtmwYIqMQROH3+qUbDBoA==",  "oebps/brow_9780385537865_epub_c23_r1.htm":"6+Jm7JvxMJbwLGcPbFZdpA==",  "oebps/brow_9780385537865_epub_fm2_r1.htm":"TiGEXdBPqTpqrDNgCzMLRg==",  "oebps/brow_9780385537865_epub_tp_r1.htm":"ISYKZZTdwDKOe1rcP6SNAQ==",  "oebps/brow_9780385537865_epub_c56_r1.htm":"w/8QpgCV01qVuxpXw/UlZg==",  "oebps/brow_9780385537865_epub_c58_r1.htm":"lWsi5ZwJPnDNYYfhcctBiw==",  "oebps/brow_9780385537865_epub_ack_r1.htm":"KIH96/g+7BUj+xmspCFIYQ==",  "oebps/brow_9780385537865_epub_c27_r1.htm":"GUSSGNR1XDzIhsRmh6Vuiw==",  "oebps/brow_9780385537865_epub_c29_r1.htm":"Wu9YtvQ5XWY96hkTUTEQaQ==",  "oebps/brow_9780385537865_epub_c96_r1.htm":"2wbmFhPVMmtOwDYTImX6eQ==",  "oebps/brow_9780385537865_epub_c90_r1.htm":"E0P9kNGAwLkoBPKKDiDbCg==",  "oebps/brow_9780385537865_epub_c92_r1.htm":"/USkUULLn1LRhYG+/Wh3tg==",  "oebps/brow_9780385537865_epub_c94_r1.htm":"f55B98/NjyDsUcpYvcal9g==",  "oebps/brow_9780385537865_epub_c50_r1.htm":"8tY+pDzbNZaWwowOnuTvkw==",  "oebps/brow_9780385537865_epub_ded_r1.htm":"LQlvZAPB85rqYUoT6mipKg==",  "oebps/brow_9780385537865_epub_c52_r1.htm":"7AzU84MBPdiCdl3jhRai0w==",  "oebps/images/brow_9780385537865_epub_cvi_r1.jpg":"cdGFD2OLmqOA60uhvzRuWg==",  "oebps/brow_9780385537865_epub_c69_r1.htm":"QH6dYEbpNDPtuzFCUE9GNg==",  "oebps/brow_9780385537865_epub_c54_r1.htm":"ocqaHW+FBuNwyz5GxBXqvA==",  "oebps/brow_9780385537865_epub_c67_r1.htm":"OL//dhZTS20eDSSxx1aZ3A==",  "oebps/brow_9780385537865_epub_c63_r1.htm":"UXPSZrHm1fVuJM3Gj9HnIw==",  "oebps/brow_9780385537865_epub_c65_r1.htm":"DZK97jWW+gjVrzIs344Ftw==",  "oebps/brow_9780385537865_epub_c61_r1.htm":"xckNv/q8WRoEVuQpdlBJhQ==",  "oebps/fonts/charissilb.ttf":"h7jVdfT7m7ZBwrTAKZ1CTw==",  "oebps/brow_9780385537865_epub_adc_r1.htm":"Q4vyx0gCfpFUQGmL2NvsvA==",  "oebps/brow_9780385537865_epub_c101_r1.htm":"LQRVRTpr9dmubtyFXdJD5Q==",  "oebps/brow_9780385537865_epub_c30_r1.htm":"OkRcd8S832ztjVYR/Bh76A==",  "oebps/brow_9780385537865_epub_c31_r1.htm":"f7jGFqJGbRPN7DFiAQdcwQ==",  "oebps/brow_9780385537865_epub_c16_r1.htm":"X1T/emKbAH5WrJhPtHOOLQ==",  "oebps/brow_9780385537865_epub_c17_r1.htm":"HX9AWiwssQ+QP92U40hpBg==",  "oebps/brow_9780385537865_epub_c12_r1.htm":"T5SJVQSolEFWmyAjoMEZug==",  "oebps/brow_9780385537865_epub_c13_r1.htm":"H3er3HrvHtT4ByEftDAkYw==",  "oebps/images/brow_9780385537865_epub_005_r1.jpg":"5QJKU+e8O1QbWZDjbfyXbA==",  "oebps/brow_9780385537865_epub_c57_r1.htm":"bDkD2Ib4kA72/a7tKTnKgQ==",  "oebps/brow_9780385537865_epub_c82_r1.htm":"CwB/bm7Hns5GYhidE4qK1w==",  "oebps/brow_9780385537865_epub_c46_r1.htm":"9/esHiJRjTTD6m9RkzAbkQ==",  "oebps/brow_9780385537865_epub_c75_r1.htm":"AxUUgP1ZD/P4anS3U/TE3Q==",  "oebps/brow_9780385537865_epub_c28_r1.htm":"Oagp8AXV1HFXldupEhOvXA==",  "oebps/brow_9780385537865_epub_c86_r1.htm":"ErIf1ngL/icna9OaqGo5tQ==",  "oebps/brow_9780385537865_epub_c35_r1.htm":"Q7Qxg5QW2NcWTrv3ow1Mmg==",  "oebps/brow_9780385537865_epub_c93_r1.htm":"YfOFtkxuJkmRW+1c9M/SMg==",  "oebps/brow_9780385537865_epub_c39_r1.htm":"u8lBpOc01NIYcKUsxBb5Dg==",  "oebps/brow_9780385537865_epub_c97_r1.htm":"O0sUuJkVparAl5nmHeBm5w==",  "oebps/brow_9780385537865_epub_c42_r1.htm":"75y2/RqA85aAqnaL2mdtIg==",  "oebps/images/brow_9780385537865_epub_cvt_r1.jpg":"ivFdMwJQwtqgosNvtcQSjA==",  "oebps/brow_9780385537865_epub_c79_r1.htm":"cF3f7rqvqLC2K/t7PVt4RA==",  "oebps/brow_9780385537865_epub_c71_r1.htm":"PHgc5Ajshh5idaSRGi8GwQ==",  "oebps/brow_9780385537865_epub_c53_r1.htm":"gqj800p4Cb71QbSJpqcoBQ==",  "oebps/brow_9780385537865_epub_c64_r1.htm":"40XfHU1+v1O/LgwUPuWDJA==",  "oebps/brow_9780385537865_epub_c68_r1.htm":"SWiz+9MobCIOsDfcpxGx1w==",  "oebps/brow_9780385537865_epub_c60_r1.htm":"qA+8lsA4A995nOMlKmeEZA==", """
    
    val msg = """{"drmKeyList": {$value}}"""
}