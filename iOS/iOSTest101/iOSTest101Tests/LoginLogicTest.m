#import <XCTest/XCTest.h>
#import "LoginLogic.h"
#import "HttpEngine.h"

// 1. 当然, 面向protocol编程, 也能写出一个mock并替代. 但有点麻烦, 每个类都要自己写个接口来抽象

// 2. 第二个办法就是下面的MockHttp, 主要是利用了Objc的鸭子类型的特性. 

@interface MockHttp: NSObject
-(NSString*) requestWithUrl: (NSString*) url;
@end

@implementation MockHttp
-(NSString*) requestWithUrl: (NSString*) url {
  return @"szw2020";
}
@end


@interface LoginLogicTest : XCTestCase
@end

@implementation LoginLogicTest

- (void)testHttp {
  LoginLogic* biz = [LoginLogic new];
  biz.http = [MockHttp new]; //类型不对, 这里会报warning. 但因为是鸭子类型,不影响我们build的
  NSString* resp = [biz loginWithName:@"" pwd:@""];
  XCTAssertEqualObjects(@"szw2020", resp);
}

/*
 // 这是用真的http去请求. 当有网络时能成功的; 但我们还要考虑到没有网络时的情况, 所以还是用mock更好!
- (void)test_RealHttpConnection {
  LoginLogic* biz = [LoginLogic new];
  biz.http = [HttpEngine new];
  NSString* resp = [biz loginWithName:@"" pwd:@""];
  NSLog(@"resp = %@", resp);
}
*/


@end
