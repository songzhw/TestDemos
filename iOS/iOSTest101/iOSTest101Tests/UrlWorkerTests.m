#import <XCTest/XCTest.h>
#import "URLWorker.h"

@interface UrlWorkerTests : XCTestCase
@end

@implementation UrlWorkerTests

- (void)testNormalScenario {
  URLWorker* worker = [URLWorker new];
  NSString* url = @"https://www.a.com/seg?a=1&b=2";
  NSDictionary* result = [worker getParams:url];
  NSDictionary* expected = @{@"a":@"1", @"b":@"2"};
  NSLog(@"result = %@", result);
  XCTAssertTrue([result isEqualToDictionary:expected]);
}

-(void)testUrlWithNoArgs_thenItShouldNotCrash {
  URLWorker* worker = [URLWorker new];
  NSString* url = @"https://www.a.com/";
  NSDictionary* result = [worker getParams:url];
  NSLog(@"result = %@", result);
  // XCTAssertTrue([result isEqualToDictionary:nil]); //这会失败. 因为nil不是字典
  XCTAssertEqual(result, nil);
}


@end
