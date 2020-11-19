#import <XCTest/XCTest.h>
#import "LoginLogic.h"
#import "HttpEngine.h"



@interface LoginLogicTest : XCTestCase
@end

@implementation LoginLogicTest

- (void)testHttp {
  LoginLogic* biz = [LoginLogic new];
  biz.http = [HttpEngine new];
  NSString* resp = [biz loginWithName:@"" pwd:@""];
  NSLog(@"resp = %@", resp);
}

/*
- (void)test_RealHttpConnection {
  LoginLogic* biz = [LoginLogic new];
  biz.http = [HttpEngine new];
  NSString* resp = [biz loginWithName:@"" pwd:@""];
  NSLog(@"resp = %@", resp);
}
*/


@end
