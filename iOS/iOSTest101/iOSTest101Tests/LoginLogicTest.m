#import <XCTest/XCTest.h>
#import "LoginLogic.h"
#import "HttpEngine.h"

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
  biz.http = [MockHttp new];
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
