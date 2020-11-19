#import "ViewController.h"
#import "LoginLogic.h"

@interface ViewController ()

@end

@implementation ViewController

- (void)viewDidLoad {
  [super viewDidLoad];
  LoginLogic* biz = [LoginLogic new];
  NSString* resp = [biz loginWithName:@"" pwd:@""];
  NSLog(@"resp = %@", resp);
}


@end
