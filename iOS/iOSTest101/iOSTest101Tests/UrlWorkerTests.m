#import <XCTest/XCTest.h>
#import "../iOSTest101/simple/URLWorker.h"

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


@end
