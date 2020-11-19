#import "ViewController.h"
#import "LoginLogic.h"
#import "HttpEngine.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
  [super viewDidLoad];
  LoginLogic* biz = [LoginLogic new];
  biz.http = [HttpEngine new];
  NSString* resp = [biz loginWithName:@"" pwd:@""];
  NSLog(@"resp = %@", resp);
}


@end
